(ns captain-ahab-bike-test.server
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.params]
            [muuntaja.middleware]
            [reitit.ring :as ring]
            [reitit.ring.coercion :as rrc]
            [captain-ahab-bike-test.route-spec :as route-spec]))

(defonce ^:private server (atom nil))

(def app
  (ring/ring-handler
    (ring/router
      [route-spec/routes]
      {:data {:middleware [ring.middleware.params/wrap-params
                           muuntaja.middleware/wrap-format
                           rrc/coerce-exceptions-middleware
                           rrc/coerce-request-middleware
                           rrc/coerce-response-middleware]}})))

(defn restart []
  (swap! server (fn [x]
                  (when x (.stop x))
                  (jetty/run-jetty
                    app
                    {:port 3000, :join? false})))
  (prn "server running in port 3000"))

;(restart)
