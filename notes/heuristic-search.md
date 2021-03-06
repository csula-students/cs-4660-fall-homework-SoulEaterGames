# Heuristic Search

## Objective

* Levels of optimization
* A* search
* Exercise

## Metrics

* Able to implement search against GWCF game

## Levels of optimization

### Depth-limited search

```js
function depthLimitedSearch(problem, limit) {
  return recursiveDLS(problem.initialState, problem, limit);
}

function recursiveDLS(node, problem, limit) {
  if (problem.goalTest(node))
    return solution(node);
  if (limit == 0) {
    return cutoff;
  }
  var cutoffOccurred = false;
  for (action in problem.actions(node)) {
    var childNode = childNode(problem, node, action);
    var result = recursiveDLS(child, problem, limit - 1);
    if (result == cutoff) {
      cutoffOccurred = true;
    } else if (result != failure) {
      return result;
    }
  }
  if (cutoffOccurred) {
    return cutoff;
  } else {
    return failure;
  }
}
```

### Iterative deepening depth-first search

```js
function iterativeDeepeningDFS(problem) {
  for (var depth = 0; depth < INTEGER.MAX_VALUE; depth ++) {
    var result = depthLimitedSearch(problem, depth);
    if (result != cutoff) {
      return result;
    }
  }
}
```

### Continue back to heuristic search

Sometimes also being called **informed search** -- one that uses problem-specific
knowledge beyond the definition of the problem itself -- can find solutions more
efficiently than uninformed strategy.

The general approach we consider is called **best-first search**. Best-first
search is an instance of general graph-search algorithm in which a node is
selected for expansion based on an evaluation function, f(n). The evaluation
function is constructed as a cost estimate, so the node with lowest evaluation is
expanded first.

## Greedy best-first search

Greedy best-first search tries to expand the node that is closest to the goal, on
the grounds that this is likely to lead to a solution quickly.

For the grid based path finding, we will use the straight line distance heuristic.

> example of showing how important heuristic function is

## A* Search

> Minimizing the total estimated solution cost

The most widely known form of best-first search is called A* search. It combines
the cost to reach the node and the cost to get from node to the goal:

```js
f(n) = g(n) + h(n)

// g(n) is the path cost from the start node to node n
// h(n) is the estimated cost of the cheapest path from n to goal
```

Thus, if we are trying to find the cheapest solution, a reasonable thing to try
first is the node with lowest value of g(n) + h(n). It turns out that this
strategy is more than just reasonable: provide that heuristic function h(n)
satisfies certain conditions, A* search is both complete and optimal. The
algorithm is almost identical to uniform-cost-search (best-first search) except
that A* uses g+h instead of g.

### Conditions for optimality: Admissibility and consistency

The first condition we require for optimality is that h(n) be an **admissible
heuristic**. An admissible heuristic is one that *never overestimates* the cost
to reach the goal. Because g(n) is the actual cost to reach n along the current
path, and f(n) = g(n) + h(n), we have as an immediate consequence that f(n) never
overestimates the true cost of a solution along with current path through n.

An example of admissible heuristic is straight line distance between the node
to the goal because straight line cost will never over estimate the cost to goal.

Second condition is called **consistency** (or sometimes **monotonicity**) is
required only for applications of A* to graph search. A heuristic function is
consistent if, for every node n and every successor n' of n generated by any
action a, the estimated cost of reaching the goal from n is no greater than the
step cost of getting to n' plus the estimated cost of reaching the goal from n':

```
h(n) < c(n, a, n') + h(n')
```

This is a form of the general **triangle inequality**, which stipulates that each
side of a triangle cannot be longer than the sum of the other two sides.

```js
function AstarSearch(start, goal) {
    // create empty queue Q      
    var frontier = new Queue();
    var exploredSet = new HashSet();
    var parents = new Map();

    // use priority queue instead of normal queue
    frontier.enqueue(v);

    // initialize gScore and hScore
    gScore = new Map(); // given every cost is infinite by default
    gScore.put(start, 0);

    fScore = new Map();
    fScore.put(start, heuristicCost(start, goal));

    while (!frontier.isEmpty()) {
        // pop with the lowest fScore
        var u = queue.dequeue();
        if (u === goal) {
          return constructPath(u)
        }
        exploredSet.push(u);

        for (node in Graph.neighbors(u)) {
            if (exploredSet.contains(node)) {
                continue;
            }
            var tempGScore = gScore.get(u) + distance(u, node);
            if (!frontier.contains(node)) {
                frontier.push(node);
            } else if (tempGScore >= gScore.get(node)) {
                continue; // skip because we are at the worse path
            }

            parent.put(node, u);
            gScore.put(node, tempGScore);
            fScore.put(node, gScore.get(node) + heuristicCost(node, goal))
        }
    }

    // no answer!
    return false;
}
```

### Memory-bounded heuristic search

Regardless of how good A* search algorithm is, A* search algorithm still uses a
lot of memory. What if we have the memory limitation? How do we modify the
algorithm?

The simplest way to reduce memory requirement for A* is to adapt the idea of
iterative deepening to the heuristic search context, resulting in the
iterative-deepening A* (IDA*) algorithm. The main difference between IDA* and
standard iterative deepening is that the cutoff used is the f-cost rather than
the depth; each iteration, the cutoff value is the smallest f-cost of any node
that exceeded the cutoff on the previous iteration.

```js
function IDA(start) {
  var bound = heuristic(start)
  while (true) {
    var t = search(start, 0, bound)
    if (t = FOUND)
      return bound
    if (t = ∞)
      return NOT_FOUND
    bound = t
  }
}

function search(node, g, bound) {
  var f = g + h(node)
  if (f > bound)
    return f
  if is_goal(node)
    return FOUND
  var min = ∞
  for neighbors in neighbors(node) {
    var t = search(neighbor, g + cost(node, neighbor), bound)
    if (t = FOUND)
      return FOUND
    if (t < min)
      min = t
  }
  return min
}
```

### Exercise: Wolf Goat Cabbage Farmer game

play game: http://jeux.lulu.pagesperso-orange.fr/html/anglais/loupChe/loupChe1.htm

xkcd solution: http://xkcd.com/1134/

Please implement WGCFGameAgent and WGCFGameAgentLevel2 with BFS, and A*;
