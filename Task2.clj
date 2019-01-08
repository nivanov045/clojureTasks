;;Task_2
(def alphabet ["a" "b" "c" "d"])
(def n 4)

(def iterRange (range 1 n))

(defn add-symbol [coll symbol]
  (filter some? (map (fn[x]
    (if(not= (subs x (-(count x) 1)) symbol)
      (str x symbol)
      )) coll) ))

(defn add-from-coll [recipient iterator]
  (map (fn[x] (add-symbol recipient x)) alphabet))

(defn return-tuple [_alphabet n]
  (reduce (fn[x y](reduce concat (add-from-coll x y))) _alphabet iterRange))

(return-tuple alphabet n)