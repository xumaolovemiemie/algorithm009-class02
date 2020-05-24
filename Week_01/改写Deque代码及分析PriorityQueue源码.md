#### 1.用 add first 或 add last 这套新的 API 改写 Deque 的代码

旧代码：

```java
Deque<String> deque = new LinkedList<String>();

deque.push("a");
deque.push("b");
deque.push("c");
System.out.println(deque);

String str = deque.peek();
System.out.println(str);
System.out.println(deque);

while (deque.size()>0){
    System.out.println(deque.pop());
}
System.out.println(deque);
```

改写后：

```java
Deque<String> deque = new LinkedList<>();
deque.addFirst("a");
deque.addFirst("b");
deque.addFirst("c");
System.out.println(deque);
String str = deque.peekLast();
System.out.println(str);
System.out.println(deque);
while (deque.size()>0){
    System.out.println(deque.pop());
}
System.out.println(deque);
```



#### 2.分析 Queue 和 PriorityQueue 的源码

**Queue**:

* boolean add(E e)：添加元素，如果成功返回true,如果因为容量限制导致失败，抛出IllegalStateException异常，如果有容量限制的队列，建议使用offer
* boolean offer(E e)：添加元素，如果成功返回true,如果因为容量限制导致失败，返回false
* E remove()：删除队列头的元素，并且返回被删除的元素，如果队列为空，抛出  NoSuchElementException
* E poll()：删除队列头的元素，并返回被删除的元素，如果队列为空，返回null
* E element()：取出队列头的元素（不删除），如果队列为空，抛出 NoSuchElementException
* E peek()：取出队列头的元素（不删除），如果队列为空，返回null



**PriorityQueue**:

实现了队列，集合接口，以及序列化

继承自AbstractQueue，AbstractQueue实现了Queue三个会抛出异常的方法，内部通过调用不会抛出异常的方法来实现

* boolean add(E e)

  ```java
  public boolean add(E e) {
      if (offer(e))
          return true;
      else
          throw new IllegalStateException("Queue full");
  }
  ```

* E remove()

  ```java
  public E remove() {
      E x = poll();
      if (x != null)
          return x;
      else
          throw new NoSuchElementException();
  }
  ```

* E element()

  ```java
  public E element() {
      E x = peek();
      if (x != null)
          return x;
      else
          throw new NoSuchElementException();
  }
  ```

PriorityQueue实现了扩容，查找元素对应下标的方法，通过数组管理元素，元素需要是可以比较的对象，如果不能比较需要明确指定比较器

* void grow(int minCapacity)：扩容方法

  ```java
  private void grow(int minCapacity) {
      int oldCapacity = queue.length;
      // 当前长度小于64的时候，每次扩容增加2，大于等于64后，每次扩容增加当前长度的一半
      int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                                       (oldCapacity + 2) :
                                       (oldCapacity >> 1));
      // 按照通用扩容方法扩容后，如果超范围，就按照指定大小进行扩容
      if (newCapacity - MAX_ARRAY_SIZE > 0)
          newCapacity = hugeCapacity(minCapacity);
      queue = Arrays.copyOf(queue, newCapacity);
  }
  
  private static int hugeCapacity(int minCapacity) {
      if (minCapacity < 0) 
          throw new OutOfMemoryError();
    	// 指定的大小超范围，就直接扩容到最大范围
      return (minCapacity > MAX_ARRAY_SIZE) ?
          Integer.MAX_VALUE :
          MAX_ARRAY_SIZE;
  }
  ```

* int indexOf(Object o)：查找元素对应下标

  ```java
  private int indexOf(Object o) {
      if (o != null) {
          final Object[] es = queue;
        	// 通过循环遍历当前数组，逐个进行比较，有相等的，直接返回对应元素下标，没有相等的返回-1
          for (int i = 0, n = size; i < n; i++)
              if (o.equals(es[i]))
                  return i;
      }
      return -1;
  }
  ```

  

