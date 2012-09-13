
(ns jiff.shell
  (:require [clojure.java.shell :as shell]
            [clojure.string :as string]))

;; Public
;; ------

(defn cmd-seq [cmds]
  (string/split
    (:out (apply shell/sh cmds))
    #"\n"))

