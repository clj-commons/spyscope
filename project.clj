(defproject clj-commons/spyscope "0.1.7-SNAPSHOT"
  :description "Trace-oriented debugging tools for Clojure(Script)"

  :url "http://github.com/dgrnbrg/spyscope"

  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :deploy-repositories [["clojars" {:url "https://repo.clojars.org"
                                    :username :env/clojars_username
                                    :password :env/clojars_password
                                    :sign-releases true}]]

  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.773"]
                 [clj-time "0.15.2"]
                 [com.andrewmcveigh/cljs-time "0.5.2"]
                 [net.cgrand/macrovich "0.2.1"]
                 [mvxcvi/puget "1.3.1" :exclusions [brandonbloom/fipp]]
                 [fipp "0.6.23"]]


  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-doo "0.1.10" :exclusions [org.clojure/clojurescript]]]

  :eval-in-leiningen true

  :profiles
  {:test {:dependencies [[lein-doo "0.1.10"]]}}

  :doo {:build "test"
        :source-paths ["src" "test"]
        :alias {:default [:chrome-headless]}}

  :cljsbuild
  {:builds
   [{:id "test"
     :source-paths ["src" "test"]
     :compiler
       {:output-dir "target/cljs/out"
        :output-to "target/cljs/tests.js"
        :main spyscope.test-runner
        :optimizations :whitespace}}]})

