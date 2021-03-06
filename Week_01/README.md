## 学习笔记

### 第1章 算法概述

#### 1.1 算法和数据结构

##### 1.1.1 算法

> 算法（algorithm）是用于解决某一类问题的公式和思想
>
> 计算机中的算法是一系列程序指令，用于解决待定的运算和逻辑问题

衡量算法好坏的重要标准有两个：

* 时间复杂度
* 空间复杂度

算法的应用领域：

* 运算
* 查找
* 排序
* 最优决策

##### 1.1.2 数据结构

数据结构的组成方式有如下几种

1. 线性结构
2. 树
3. 图
4. 其他数据结构，如：跳表、哈希链表、位图

#### 1.2 时间复杂度

> 若存在函数f(n)，使得当n趋近于无穷大时，T(n)/f(n)的极限值为不等于零的常数，则称f(n)是T(n)的同数量级函数。记作T(n)=O(f(n))，称为O(f(n))，O为算法的渐进时间复杂度，简称为时间复杂度

常见的复杂度按照从低到高的顺序，包括O(1)、O(logn)、O(n)、O(nlogn)、O(n<sup>2</sup>)等

推导时间复杂度常用原则

* 如果运行时间是常数量级，则用常熟1表示
* 只保留时间函数中的最高阶项
* 如果最高阶项存在，则省去最高阶项前面的系数

例：

1. T(n) = 3n，最高项为3n，省去系数3，时间复杂度为：**T(n) = O(n)**
2. T(n) = 5logn，最高阶项为5logn，省去系数5，时间复杂度为：**T(n)= O(logn)**
3. T(n) = 2，只有常数量级，时间复杂度为：**T(n) = O (1)**
4. T(n) = 0.5n<sup>2</sup>+0.5n，最高阶项为0.5n<sup>2</sup>，省去系数，时间复杂度为：**T(n) = O(n<sup>2</sup>)**

#### 1.3 空间复杂度

> 空间复杂度是对一 个算法在运行过程中临时占用存储空间大小的量度，用大O表示，记作S(n)=O(f(n))

常见的空间复杂度按照从低到高的顺序，包括O(1)、O(n)、O(n<sup>2</sup>)等，递归算法的空间复杂度和递归深度成正比



### 第2章 数据结构基础

#### 2.1 数组

> 数组是有限个相同类型的变量所组成的有序集合，数组中的每一个变量被称为元素。
>
> 数组是最简单、常用的数据结构，物理存储方式是顺序存储，访问方式是随机访问，利用下标查找元素时间复杂度为O(1)，中间插入删除元素的时间复杂度是O(n)

数组特点：

1. 数组中的每一个元素也有着自己的下标，只不过这个下标从0开始，一直到数组长度-1
2. 数组在内存中顺序存储，因此可以很好的实现逻辑上的顺序表

数组的基本操作：

1. **读取元素**：由于数组在内存中顺序存储，所以只要给出一个数组的下标，就可以读取到对应的数组元素
2. **更新元素**：要把数组中某一个元素的值替换为一个新值，只需要利用下标，直接把 新值赋给该元素
3. **插入元素**：插入元素分为三种基本的情况
   * 尾部插入：直接把元素放在数组的尾部空闲位置
   * 中间插入：需要把插入位置以及后面的元素向后移动，然后再插入元素到对应的位置
   * 超范围插入：如果插入的下标小于0或者大于等于数组长度，会抛出异常，如果需要插入，需要自己对数组金星秀扩容处理
4. **删除元素**：数组删除和插入相反，末尾直接删除，如果在中间或者开头，需要把删除元素后面的元素都向前挪动1位



**ArrayList**是java基于数组实现的一个类，在中间插入和删除元素都涉及到当前位置到末尾需要进行后移或者前移一位，在新增元素的同时还需要判断数组长度是否足够，不够会进行数组扩充*2，然后进行数组的拷贝操作，所以在ArrayList中不建议进行大量的添加和删除操作，查找的时间复杂度为O(1),添加删除的时间复杂度为O(n);

#### 2.2 链表

> 链表是一种在物理上非连续、非顺序的数据结构，由若干节点(node)组成，每个节点包含指向下一个节点的指针。
>
> 链表的物理存储方式是随机存储，访问方式是顺序访问，查找链表节点的时间复杂度是O(n)，中间插入、删除节点的时间复杂度是O(1)。

**单链表**：每个节点包含两个部分，一部分是存放数据的变量data，另一部分是指向下一个节点的指针next

**双向链表**：每个节点除了data和next指针，还有指向前置节点的prev指针

**循环链表**：最后一个节点的next指针，指向第一个节点

链表的基本操作：

1. **查找节点**：链表中的数据只能按顺序进行访问，最坏的时间复杂度为O(n)
2. **更新节点**：在不考虑查找节点的过程情况下，链表更新过程只需要直接把旧数据替换成新数据就行
3. **插入节点**：和数组类似，分为三种基本情况
   * 尾部插入：直接把最后一个节点的next指针指向新插入的节点就可以
   * 头部插入：1. 把新节点的next指针指向原先的头节点  2. 把新节点变成链表的头节点
   * 中间插入：1. 新节点的next指针指向插入位置的节点  2.插入位置前置节点的next指针，指向新节点
4. **删除元素**：删除同样分为三种情况
   * 尾部删除：把倒数第二个节点的next指针置空
   * 头部删除：把链表的头节点设置为原先头节点的next指针
   * 中间删除：把要删除节点的前置节点的next指针，指向要删除元素的下一个节点

|      | 查找 | 更新 | 插入 | 删除 |
| :--: | :--: | :--: | :--: | :--: |
| 数组 | O(1) | O(1) | O(n) | O(n) |
| 链表 | O(n) | O(1) | O(1) | O(1) |

**LinkList**的元素一般是定义的一个Node，同时Node内会分别有字段指向该节点的后面一位和前面一位，Java中LinkList是双向链表,查找的时间复杂度为O(n),添加和删除的时间复杂度为O(1)

#### 2.3 栈

> 栈是一种线性逻辑结构，可以用数组实现，也可以用链表实现
>
> 栈包含入栈和出栈操作，遵循先入后出的原则（FILO）

第一个进入的元素存放的位置叫做**栈底（bottom）**，最后进入的元素存放的位置叫做**栈顶（top）**

**入栈（push）**：将新的元素放入栈中，只允许从栈顶一侧放入元素，新元素的位置会成为新的栈顶

**出栈（pop）**：把元素从栈中弹出，只有栈顶元素才允许出栈，出栈元素的前一个元素将会成为新的栈顶

栈的输出顺序和输入顺序相反，所以栈通常用于对“历史”的回溯，一般递归逻辑可以用栈来代替

#### 2.4 队列

> 队列也是一种线性逻辑结构，可以用数组实现，也可以用链表实现
>
> 队列包含入队和出队操作，遵循先入先出的原则（FIFO）

队列的出口端叫做**队头（front）**，队列的入口端叫做**队尾（rear）**

**入队（enqueue）**：把新元素放入队列中，只允许在队尾的位置放入元素，新元素的下一个位置将会成为新的队尾

**出队（dequeue）**：把元素移出队列，只允许在队头一侧移出元素，出队元素的后一个元素将会成为新的队头

队列 输出顺序和输入顺序相同，所以队列通常用于对历史的回放，也就是按照历史的顺序，把历史重演一遍

##### 特殊队列

1. 循环队列⚠️

   循环队列的队尾指针指向的位置永远空一位，所以最大容量会比数组长度小1

   当循环队列储存满时，***(队尾下标 + 1) % 数组长度 = 队头下标***

2. 双端队列

   通过结合队列和栈的特点，实现可以从对头一端入队或出队，从队尾一端也可以入队或出队

3. 优先队列

   该队列不属于线性数据结构，是基于二叉堆来实现的

#### 2.5 散列表

> 散列表也叫哈希表，是存储key-value映射的集合。对于某一个key，散列表可以在接近O(1)的时间内进行读写操作。散列表通过哈希函数实现key和数组下标的转换，通过开放寻址法和链表法来解决哈希冲突

散列表中会用一个哈希函数来实现key和数组下标的转换，最简单的方法如下

**index = HashCode(Key) % Array.length**

散列表的常用操作：

* 写操作（put）：写操作就是在散列表中插入新的键值对
  1. 通过哈希函数，把key转化成数组下标
  2. 如果数组下标5对应的位置没有元素，就把这个entry填充到数组下标5的位置，如果下标5位置有元素，则会产生哈希冲突，可以通过开放寻址法和链表法解决
     * **哈希冲突** ：因为数组长度有限，当插入的Entry越来有越多时，不同的key通过哈希函数获得的下标可能相同的情况
     * **开放寻址法**：当一个key通过哈希函数获得对应的数组下标已被占用时，可以根据某种规则寻找下一个空挡位置
     * **链表法**：HashMap数组的每一个元素不仅是一个Entry对象，还是一个链表的头节点。每一个Entry对象通过next指针指向它的下一个Entry节点。当新来的Entry映射到与之冲突的数组位置时，只需要插入到对应的链表中即可。
* 读操作（get）
  1. 通过哈希函数，把Key转化成数组下标
  2. 找到数组下标所对应的元素，如果这个元素的Key为查找的Key，那么就找到了，如果Key不是查找的Key，由于每个元素都与一个链表对应，可以顺着链表往下找



### 第3章 树

#### 3.1 树和二叉树

> 