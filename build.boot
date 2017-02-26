(set-env!
  :resource-paths #{"src"}
  :dependencies '[[org.clojure/clojure "1.8.0"]
                  [org.clojure/clojurescript "1.9.494"]
                  [adzerk/boot-cljs "1.7.228-2"]])

(task-options!
  pom {:project 'power
       :version "0.0.1"}
  jar {})

(require '[adzerk.boot-cljs :refer [cljs]])

(deftask dev []
  (comp
   (watch)
   (cljs :source-map true :optimizations :none)
   (target "target/")))
