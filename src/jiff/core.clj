
(ns jiff.core
  (:use jiff.vcs
        [clojure.pprint :only [pprint]])
  (:require jiff.svn))

(defn ^{:doc "Main method that will take a VCS type and some paths,
  and then pretty print the file diffs from it."}
  -main [vcs from to]
  (pprint (jiff-seq {:vcs (keyword vcs)
                     :from from
                     :to to}))
  (shutdown-agents))

