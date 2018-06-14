(ns captain-ahab-bike-test.handler
  (:require [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [reitit.ring :as ring]))

(defn handler [_]
  {:status 200, :body "ok"})

(defn wrap [handler id]
  (fn [request]
    (update (handler request) :via (fnil conj '()) id)))

(def app
  (ring/ring-handler
    (ring/router
      ["/api" {:middleware [#(wrap % :api)]}
       ["/ping" handler]
       ["/admin" {:middleware [[wrap :admin]]}
        ["/db" {:middleware [[wrap :db]]
                :delete {:middleware [[wrap :delete]]
                         :handler handler}}]]]
      {:data {:middleware [[wrap :top]]}}) ;; all routes
    (ring/create-default-handler)))
