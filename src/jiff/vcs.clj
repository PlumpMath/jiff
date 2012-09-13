
(ns jiff.vcs)

; Returns a sequence of the diffs from the specified
; paths in the VCS.  The map should be of the format:
;
; {:vcs :svn
;  :from "http://svn.com/repo/tags/1.1"
;  :to "http://svn.com/tags/1.2"}
;
; And will then return a sequence of maps describing
; each change in the differences.

(defmulti jiff-seq :vcs)

