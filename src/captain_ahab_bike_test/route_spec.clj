(ns captain-ahab-bike-test.route-spec
  (:require
    ;; validation
    [clojure.spec.alpha :as s]
    [spec-tools.spec :as spec]
    ;; logic
    [captain-ahab-bike-test.bike :as bike]
    ;; ring and routing
    [reitit.coercion.spec]))

;; wrap into Spec Records to enable runtime conforming
(s/def ::bikes spec/int?)
(s/def ::name spec/string?)

(def routes
  ["/api" {:coercion reitit.coercion.spec/coercion}
   ["/stations" {:name ::stations
                 :responses {200 {:body (s/coll-of (s/keys :req-un [::name ::bikes]))}}
                 :get {:handler (fn [{{{:keys []} :query} :parameters}]
                                  (bike/get-bike-stations-and-bikes))}}]
   ["/closestBike"
    {:name ::closestBike
     :responses {200 {:body (s/keys :req-un [::name ::bikes])}}
     :get {:handler (fn [{{{:keys []} :query} :parameters}]
                      (bike/get-closest-bike-station-with-bikes))}}]])


;; List all stations
;; List only stations with bikes
;; list closes station with bikes
;; Closest station with empty docks to put my bike


;; Post example for addition
;:post {:summary "plus with body-params"
;       :parameters {:body (s/keys :req-un [::x ::y])}
;       :handler (fn [{{{:keys [x y]} :body} :parameters}]
;                  {:status 200
;                   :body {:name (+ x y)}})}

