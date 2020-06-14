#### 二叉树搜索

* 每个节点都要访问一次

* 每个节点仅仅要访问一次

* 对于节点的访问顺序不限

  * `深度优先（DFS）`：depth first search

    ```python
    visited = set()
    
    def dfs(node, visited):
      if node in visited:
        # already visited
        return
      visited.add(node)
      # process current node here
      for next_node in node.children():
        if not next_node in visited:
          dfs(next node,visited)
          
    # 不用递归实现
    def dfs(self,tree):
      if tree.root is None:
        return []
      visited, stack = [], [tree.root]
      
      while(stack):
        node = stack.pop()
        visited.add(node)
        
        process(node)
        nodes = generate_related_nodes(node)
        stack.push(nodes)
    ```

  * `广度优先（BFS）`：breadth first search

    ```python
    visited = set()
    
    def bfs(graph, start, end):
      queue = []
      queue.append([start])
      visited.add(start)
      
      while queue:
        	node = queue.pop()
          visited.add(node)
          
          process(node)
          nodes = generate_related_nodes(node)
          queue.push(nodes)
    ```

#### 二分查找

##### 1. 二分查找前提

* 目标函数单调性（单调递增或者递减）
* 存在上下界（bounded)
* 能够通过索引访问（index accessible)

##### 2. 代码模板

```python
left, right = 0, len(array) - 1 
while left <= right: 
	  mid = (left + right) / 2 
	  if array[mid] == target: 
		    # find the target!! 
		    break or return result 
	  elif array[mid] < target: 
		    left = mid + 1 
	  else: 
		    right = mid - 1
```

