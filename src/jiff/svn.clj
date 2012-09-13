
(ns jiff.svn
  (:use jiff.core))

(def index-re #"Index: (.+)")

(defn- re-first [re string]
  (second (re-find re string)))

(defn- to-file [[[index] [_ from to & lines]]]
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
  [{:keys [from to]}])

