(ns captain-ahab-bike-test.bike
  (:require [captain-ahab-bike-test.datalayer :as data]))


(defn get-bike-count
  [bike-data-vector]
  (as-> bike-data-vector bd
        (filter #(= "NbBikes" (get % "key")) bd)
        (first bd)
        (get bd "value")
        (when bd (read-string bd))))

(defn get-bike-stations-and-bikes
  []
  (prn "Starting get bike logic . . .")
  (let [all-bike-stations (data/pull-bike-list)
        _ (prn (count all-bike-stations))
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
    (prn "Result: " result-bike-data)

    result-bike-data))


(defn get-closest-bike-station-with-bikes
  []
  (prn "Starting get bike logic . . .")
  (let [all-bike-stations (data/pull-bike-list)
        relevant-bike-stations (->> (slurp "resources/bike_station_list.edn")
                                    read-string
                                    (map :id)
                                    set)
        relevant-bike-data (filter #(relevant-bike-stations (get % "id")) all-bike-stations)
        bike-stations-with-bikes (filter #(> (get-bike-count (get % "additionalProperties")) 0) relevant-bike-data)
        closest-bike-data (first (sort-by #(get % "distance") bike-stations-with-bikes))
        result-bike-data {:name (get closest-bike-data "commonName")
                          :bikes (get-bike-count (get closest-bike-data "additionalProperties"))}]

    (prn "Result: " result-bike-data)

    result-bike-data))
