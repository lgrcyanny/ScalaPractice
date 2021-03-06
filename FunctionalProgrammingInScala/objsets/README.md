# Make Summary About TweetSet Implementation
1.union performance issue<br\>
Must use tail recersion optimization

```scala
def union(that: TweetSet) = right.union(left.union(that.incl(elem)))
```

Please refer to [Coursera FAQ](https://class.coursera.org/progfun-005/forum/thread?thread_id=749#post-2813)

2.mostRetweeted performance issue<br\>
use lazy val optimization to avoid NoSuchElementException, and calculate leftMost and rightMost only
once

```scala
def mostRetweeted: Tweet = {
    lazy val leftMost = left.mostRetweeted // Lazy the value to avoid NoSuchElement Exception
        lazy val rightMost = right.mostRetweeted
        if (!left.isEmpty && leftMost.retweets > elem.retweets) {
            if (!right.isEmpty && rightMost.retweets > leftMost.retweets)
                rightMost
            else leftMost
        } else if (!right.isEmpty && rightMost.retweets > elem.retweets) {
            rightMost
        } else {
            elem
        }
}
```
