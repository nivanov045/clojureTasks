;;Task_1
(defn my-map [f coll]
  (reduce (fn [x y] (conj x (f y))) [] coll))

(my-map inc [1 2 3 4 5])

(defn my-filter [pred coll]
  (reduce (fn[x y] 
    (if (pred y)
      (conj x y)
      (conj x))) [] coll))

(my-filter (fn [n] (= 0 (mod n 3)))
  [1 2 3 4 5 6 7 8 9 10])