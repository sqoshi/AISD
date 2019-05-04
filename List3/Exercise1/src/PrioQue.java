import java.util.*;

class PrioQue {
    private ArrayList<Task> heap;

    Map<Integer, ArrayList<Integer>> map = new HashMap<>();

    public PrioQue() {
        heap = new ArrayList<>();
    }


    public void insert(int val, int priority) {
        Task task = new Task(val, priority);
        heap.add(task);

        ArrayList<Integer> integers = new ArrayList<>();

        if(!map.containsKey(val)){
            integers.add(heap.size() - 1);
            map.put(val, integers);
        } else {
            ArrayList<Integer> test = map.get(val);
            test.add(heap.size() - 1);
            map.put(val, test);
        }

        heapup(heap.size() - 1);
    }


    void Empty() {
        if (heap.size() == 0) System.out.println("1");
        else System.out.println("0");
    }

    void Top() {
        if (heap.size() == 0) System.out.println();
        else System.out.println(heap.get(0).val);
    }

    public Task Pop() {
        if (heap.size() == 0) {
            System.out.println();
            return null;
        }
        else {
            Task deletedTask = heap.get(0);
          //  System.out.println(heap.get(0).val);

            map.get(heap.get(0).val).remove(Integer.valueOf(0));
            map.get(heap.get(heap.size() - 1).val).remove(Integer.valueOf(heap.size() - 1));
            map.get(heap.get(heap.size() - 1).val).add(Integer.valueOf(0));


            Collections.swap(heap, 0, heap.size() - 1);
            heap.remove(heap.size() - 1);

            heapdown(0);
            return deletedTask;
        }

    }

    void Priority(int val, int prio){
        ArrayList<Integer> vals = map.get(val);
        vals.forEach((e) -> {
            heap.get(e).priority = heap.get(e).priority<prio ? prio : heap.get(e).priority;
        });
    }


    void print() {
        heap.forEach((e) -> System.out.print(e.toString() + "\t"));
    }

    void heapup(int i) {
        if (i >= 0) {
            int parent = (i - 1) / 2;
            if (heap.get(parent).priority > heap.get(i).priority) {

                map.get(heap.get(parent).val).remove(Integer.valueOf(parent));
                map.get(heap.get(parent).val).add(Integer.valueOf(i));
                map.get(heap.get(i).val).remove(Integer.valueOf(i));
                map.get(heap.get(i).val).add(Integer.valueOf(parent));

                Collections.swap(heap, parent, i);
                heapup(parent);
            }
        }
    }


    int higherPrio(int parent, int child) {
        if (child < heap.size() && heap.get(child).priority < heap.get(parent).priority) return child;
        else return parent;
    }


    int getChild(int parent) {
        return higherPrio(higherPrio(parent, 2 * parent + 1), 2 * parent + 2);
    }


    void heapdown(int i) {
        if (heap.size() != 0) {
            int child = getChild(i);
            if (child != i) {
                Collections.swap(heap, i, child);

                map.get(heap.get(child).val).remove(Integer.valueOf(child));
                map.get(heap.get(child).val).add(Integer.valueOf(i));
                map.get(heap.get(i).val).remove(Integer.valueOf(i));
                map.get(heap.get(i).val).add(Integer.valueOf(child));

                heapdown(child);
            }
        }

    }

    public static void main(String[] args) {
        PrioQue que = new PrioQue();

        while (true) {
            String fun = new Scanner(System.in).nextLine();

            switch (fun.split(" ")[0]) {
                case "insert": {
                    que.insert(Integer.parseInt(fun.split(" ")[1]),Integer.parseInt(fun.split(" ")[2]));
                    break;
                }
                case "priority": {
                    que.Priority(Integer.parseInt(fun.split(" ")[1]),Integer.parseInt(fun.split(" ")[2]));
                    break;
                }
                case "empty": {
                    que.Empty();
                    break;
                }
                case "top": {
                    que.Top();
                    break;
                }
                case "pop": {
                    que.Pop();
                    break;
                }
                case "print": {
                    que.print();
                    break;
                }
                default: {
                    System.out.println("Default");
                }
            }


        }
    }


}