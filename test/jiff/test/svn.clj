
(ns jiff.test.svn
  (:use midje.sweet
        jiff.svn))

(def lines (clojure.string/split
            (slurp "test/smutty.diff")
            #"\n"))

(facts "about files in a diff"
  (count (files-from lines)) => 3)

(facts "about the structure of files"
  (first (files-from lines)) => (contains {:path "release/library/smarty/plugins/function.link.php"})
  (first (files-from lines)) => (contains {:from "release/library/smarty/plugins/function.link.php\t(revision 472)"})
  (first (files-from lines)) => (contains {:to "release/library/smarty/plugins/function.link.php\t(revision 473)"}))

