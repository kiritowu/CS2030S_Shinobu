# Maybe<T>
More information can be found in [Lab 7 Slide](https://docs.google.com/presentation/d/1RyhqIkARsIa0SCKwwIfdM5JGZd6Yboh6tvwTpSgN7qs/edit?usp=sharing) <br>

Recap our `Maybe<T>` class.
- Factory Methods
  - `public static <T> Maybe<T> of(T val)`
  - `public static <T> Maybe<T> some(T val)`
  - `public static <T> Maybe<T> none()`
- Operations
  - `public Maybe<T> filter(BooleanCondition<? super T> pred)`
  - `public <U> Maybe<U> map(Transformer<? super T, ? extends U> func)`
  - `public <U> Maybe<U> flatMap(Transformer<? super T,
                                 ? extends Maybe<? extends U>> func)`
- Retrieval
  - `public <U extends T> T orElse(U u)`
  - `public T orElseGet(Producer<? extends T> prod)`
  - `public void ifPresent(Consumer<? super T> cons)`

**Note:** `Maybe::get()` method is `protected` and cannot be used.  You are 
**NOT** allowed to modify this to `public`.

# Lazy<T>
More information can be found in [Lab 9 Slides](https://docs.google.com/presentation/d/14MM9_8CJ7mZ-FBjQgI1Z0ZKUYHhBorxZgygw6KboxmE/edit?usp=sharing) <br>

Recap our `Lazy<T>` class.
- Factory Methods
  - `public static <T> Lazy<T> of(T val)`
    Create a lazy value that is already known. No computation needed; memoized immediately.
  - `public static <T> Lazy<T> of(Producer<? extends T> producer)`
    Create a lazy value that is not known. No computation needed; memoized when `get()` is invoked.  
    
- Operations (that are Lazily computed)
  - `public <R> Lazy<R> map(Transformer<? super T, ? extends R> mapper)`
  - `public <R> Lazy<R> flatMap(Transformer<? super T, ? extends Lazy<? extends R>> mapper)`
  - `public <S, R> Lazy<R> combine(Lazy<S> s, Combiner<? super T, ? super S, ? extends R> f)`
  - `public Lazy<Boolean> filter(BooleanCondition<? super T> pred)`
  
- Retrieval
  - `public T get()`
  `get()` method that is called when the value is needed. If the value is already available, return that value; otherwise, compute the value and return it. The computation should only be done once for the same value.
  
# InfiniteList<T>
More information can be found in [Lab 9 Slides](https://docs.google.com/presentation/d/14MM9_8CJ7mZ-FBjQgI1Z0ZKUYHhBorxZgygw6KboxmE/edit?usp=sharing) <br>

Recap our `InfiniteList<T>` class.
- Factory Methods
  - `public static <T> InfiniteList<T> generate(Producer<T> prod)`
    [prod(), prod(), prod(), ...]
  - `public static <T> InfiniteList<T> iterate(T seed, Transformer<? super T, ? extends T> next)`
    [seed, next(seed), next(next(seed)), ...]
  - `public static <T> InfiniteList<T> sentinel()`
- Operations
  - `public InfiniteList<T> filter(BooleanCondition<? super T> pred)`
  - `public <U> InfiniteList<U> map(Transformer<? super T, ? extends U> func)`
  - `public <U> InfiniteList<U> flatMap(Transformer<? super T, ? extends InfiniteList<? extends U>> func)`
  - `public InfiniteList<T> append(InfiniteList<T> list)`
- Finite Operations
  - `public InfiniteList<T> limit(int n)`
  - `public InfiniteList<T> takeWhile(BooleanCondition<? super T> cond)`
- Retrieval
  - `public T head()`
  - `public InfiniteList<T> tail()`
- Terminal
  - `public List<T> toList()`
    **Important:** You are not allowed to use `toList()`
  - `public U reduce(U identity, Combiner<U, ? super T, U> accumulator)`
  - `public long count()`
- Predicates
  - `public boolean isSentinel()`