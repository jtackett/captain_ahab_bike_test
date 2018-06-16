(ns captain-ahab-bike-test.datalayer
  (:require [clj-http.client :as client]
            [cheshire.core :as json]))

;; These would obviously be ENV vars in prod/server deployments
(def app_id "86abb5ba")
(def app_key "025de1f94d5f964d31a7163c0f7c3b2c")

(defn pull-bike-list
  []
  (prn "Getting bike data from bikepoint . . .")
  (let [response (client/get (str "https://api.tfl.gov.uk/bikepoint?app_id="app_id"&app_key="app_key))]
    (if (= (:status response) 200)
      (json/parse-string (:body (client/get (str "https://api.tfl.gov.uk/bikepoint?app_id="app_id"&app_key="app_key))))
      false ;; returning false to show the external API failed
      )))

