(ns captain-ahab-bike-test.datalayer
  (:require [clj-http.client :as client]))


(def app_id "86abb5ba")
(def app_key "025de1f94d5f964d31a7163c0f7c3b2c")

(defn pull-bike-list
  []
  (prn "Getting bike data from bikepoint . . .")
  (client/get (str "https://api.tfl.gov.uk/bikepoint?app_id="app_id"&app_key="app_key)))

