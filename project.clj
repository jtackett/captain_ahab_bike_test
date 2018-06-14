(defproject captain_ahab_bike_test "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]

                 ;; Web app / routing
                 [ring/ring-defaults "0.2.1"]
                 [metosin/reitit-ring "0.1.0"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler captain-ahab-bike-test.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})
