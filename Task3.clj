;;Task3
(use '[clojure.test :only [is]])

(defn squareOfTrapezeByGeometry [a b h]
  (* 0.5 h (+ a b)))

(defn squareOfTrapezeOnPlot [f k h]
  (squareOfTrapezeByGeometry (f (* k h)) (f (* (inc k) h)) h))

(def integralInPointsOfNet (memoize (fn [f n h]
  (if (= n 0)
    (squareOfTrapezeOnPlot f 0 h)
    (+ (squareOfTrapezeOnPlot f n h) (integralInPointsOfNet f (dec n) h))))))

(defn lastPointOfNet [x h]
  (* h (int (/ x h))))

(defn integralInTail [f x h]
  (squareOfTrapezeByGeometry (f (lastPointOfNet x h))
          (f x)
          (- x (lastPointOfNet x h))))

(defn integralFull [f x h]
  (+ (integralInTail f x h) (integralInPointsOfNet f (int (/ x h)) h)))

(defn integral [f h]
  (fn [x] (if (<= x 0)
    0
    (integralFull f x h))))

(defn foo [x] (Math/sin x))
(defn bar [x] (- (Math/cos 0) (Math/cos x)))

(def h 0.1)
(def x 10)
(def randEps 0.515)

(defn testTime[]
  (time ((integral foo h) x))
  (time ((integral foo h) x))
  (time ((integral foo h) x))
  (time ((integral foo h) x))
  (time ((integral foo h) (+ x randEps)))
  (time ((integral foo h) (+ x randEps)))
  (time ((integral foo h) (+ x randEps)))
  (time ((integral foo h) (+ x randEps)))
  )

(defn unit-tests []
  (print "Bar: ")
  (println (bar x))

  (print "Foo: ")
  (println ((integral foo h) x))

  (print "Error: ")
  (println (- (bar x) ((integral foo h) x)))

  (print "Null-test: ")
  (is (= ((integral foo h) 0) 0))
  )

(testTime) (unit-tests)