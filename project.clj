(defproject captain_ahab_bike_test "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.9.0"]

                 ;; Web app / routing
                 [ring "1.6.3"]
                 [metosin/muuntaja "0.4.1"]
                 [metosin/reitit "0.1.2"]

                 ;; External HTTP requests
                 [clj-http "3.9.0"]
                 ]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler captain-ahab-bike-test.handler/app
         :adapter {:port 8085}}
  :aot :all
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})
