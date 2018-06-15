(ns captain-ahab-bike-test.route-spec
  (:require [clojure.spec.alpha :as s]
            [spec-tools.spec :as spec]
            [reitit.coercion.spec]
            [captain-ahab-bike-test.bike :as bike]))

;; wrap into Spec Records to enable runtime conforming
(s/def ::x spec/int?)
(s/def ::y spec/int?)
(s/def ::total spec/int?)

(def routes
  ["/spec" {:coercion reitit.coercion.spec/coercion}
   ["/plus" {:name ::plus
             :responses {200 {:body (s/keys :req-un [::total])}}
             :get {:summary "plus with query-params"
                   :parameters {:query (s/keys :req-un [::x ::y])}
                   :handler (fn [{{{:keys []} :query} :parameters}]
                              {:status 200
                               :body (bike/get-bike-stations-and-bikes)})}
             :post {:summary "plus with body-params"
                    :parameters {:body (s/keys :req-un [::x ::y])}
                    :handler (fn [{{{:keys [x y]} :body} :parameters}]
                               {:status 200
                                :body {:total (+ x y)}})}}]])


;; List all stations
;; List only stations with bikes
;; list closes station with bikes
;; Closest station with empty docks to put my bike
