(ns captain-ahab-bike-test.server
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.params]
            [muuntaja.middleware]
            [reitit.ring :as ring]
            [reitit.ring.coercion :as rrc]
            [captain-ahab-bike-test.route-spec :as route-spec]
            [ring.middleware.basic-authentication :refer [wrap-basic-authentication]]))

(defonce ^:private server (atom nil))

;; Obviously these would be ENV vars in a real config
(defn authenticated? [username pass]
  (and (= username "foo")
       (= pass "bar")))

(def app
  (wrap-basic-authentication
    (ring/ring-handler
      (ring/router
        [route-spec/routes]
        {:data {:middleware [ring.middleware.params/wrap-params
                             muuntaja.middleware/wrap-format
                             rrc/coerce-exceptions-middleware
                             rrc/coerce-request-middleware
                             rrc/coerce-response-middleware]}}))
    authenticated?))

(defn restart []
  (swap! server (fn [x]
                  (when x (.stop x))
                  (jetty/run-jetty
                    app
                    {:port 3000, :join? false})))
  (prn "server running in port 3000"))

;(restart)
