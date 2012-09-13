
(ns jiff.svn
  (:use jiff.vcs
        jiff.shell))

(def index-re #"Index: (.+)")

(defn- ^{:doc "Returns the first group match in the regex
  against the specified string."}
  re-first [re string]
  (second (re-find re string)))

(defn- ^{:doc "Turns a pair of files index and its diff lines
  into a more structured map."}
  to-file [[[index] [_ from to & lines]]]
  {:path (re-first index-re index)
   :from (re-first #"--- (.+)" from)
   :to (re-first #"\+\+\+ (.+)" to)
   :lines (drop 3 lines)})

;; Public
;; ------

(defn files-from [lines]
  (->> lines
       (partition-by #(re-find index-re %))
       (partition 2)
       (map to-file)))

(defmethod jiff-seq :svn
  [{:keys [from to]}]
  (files-from
    (cmd-seq ["svn" "diff" from to])))

