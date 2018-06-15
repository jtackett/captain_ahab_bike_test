(ns captain-ahab-bike-test.bike
  (:require [captain-ahab-bike-test.datalayer :as data]))


(defn get-bike-count
  [bike-data-vector]
  (-> (filter #(= "NbBikes" (get % "key")) bike-data-vector)
      first
      (get "value")))

(defn get-bike-stations-and-bikes
  []
  (prn "Starting get bike logic . . .")
  (let [all-bike-stations (data/pull-bike-list)
        relevant-bike-stations (read-string (slurp "resources/bike_station_list.edn"))
        relevant-bike-ids (set (map :id relevant-bike-stations))
        relevant-bike-data (filter #(relevant-bike-ids (get % "id")) all-bike-stations)
        result-bike-data (mapv #(identity
                                  {:name (get % "commonName")
                                   :bikes (get-bike-count (get % "additionalProperties"))})
                               relevant-bike-data)]

    ;(prn relevant-bike-stations)
    ;(prn relevant-bike-ids)
    ;(prn relevant-bike-data)
    (prn result-bike-data)

    result-bike-data
    ))
