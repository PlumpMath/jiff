
Jiff
====

Jiff is a small library for transforming diffs into Clojure sequences
of data structures.

Installation
------------

Jiff is available from Clojars.

Usage
-----

```clojure
(ns my.ns
  (:use jiff.vcs)
  (:require jiff.svn))

(def files (jiff-seq {:vcs :svn
                      :from "svn://server/tags/1.1"
                      :to "svn://server/tags/1.2"}))
```

Running with Leiningen
----------------------

You can also run Jiff straight through Leiningen like:

```
lein run :svn http://server/path1 http://server/path2
```

