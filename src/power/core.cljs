(ns power.core
  (:require [cljs.nodejs :as node]))

(def electron
  (node/require "electron"))

(def path
  (node/require "path"))

(def url
  (node/require "url"))

;; wtf node?
(def __dirname (.resolve path ""))

(defn run []
  (let [window (.-BrowserWindow electron)
        win (window. (clj->js {:width 800 :height 600}))
        html-file (.join path __dirname "resources" "index.html")]
    (js/console.log html-file)
    (doto win
      (.loadURL (.format url
                 (clj->js
                  {:pathname html-file
                   :protocol "file:"
                   :slashes true})))
      (.-webContents.openDevTools))))

(defn main []
  (let [app (.-app electron)]
    (.on app "ready" run)))
                                
