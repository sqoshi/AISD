import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class PrioQue {

    private Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    private ArrayList<Task> heap;//zbior obiektow elementow taskow z ktorych tworze kopiec

    PrioQue() {
        heap = new ArrayList<>();

    }


    void insert(int val, int priority) {
        Task task = new Task(val, priority);
        heap.add(task);

        ArrayList<Integer> integers = new ArrayList<>();

        if (!map.containsKey(val)) {
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
        if (heap.size() == 0)
            System.out.println("1");
        else System.out.println("0");
    }

    void Top() {
        if (heap.size() == 0) System.out.println();
        else System.out.println(heap.get(0).val);
    }

    Task Pop() {
        if (heap.size() == 0) {
            System.out.println();
            return null;
        } else {
            Task deletedTask = heap.get(0);
            //  System.out.println(heap.get(0).val);

            map.get(heap.get(0).val).remove(Integer.valueOf(0));
            map.get(heap.get(heap.size() - 1).val).remove(Integer.valueOf(heap.size() - 1));
            map.get(heap.get(heap.size() - 1).val).add(0);


            Collections.swap(heap, 0, heap.size() - 1);
            heap.remove(heap.size() - 1);

            heapdown(0);
            return deletedTask;
        }

    }

    void Priority(int val, int prio) {
        ArrayList<Integer> vals = map.get(val);//need to heap up
        vals.forEach((e) -> {
            //heap.get(e).priority = heap.get(e).priority > prio ? prio : heap.get(e).priority;
            if (heap.get(e).priority > prio) {
                heap.get(e).priority = prio;
                heapup(e);

            }
        });
    }

    void print() {

        heap.forEach((e) -> System.out.print(e.toString() + "\t"));
    }

    private void heapup(int i) {
        if (i >= 0) {
            int parent = (i - 1) / 2;
            if (heap.get(parent).priority > heap.get(i).priority) {

                map.get(heap.get(parent).val).remove(Integer.valueOf(parent));
                map.get(heap.get(parent).val).add(i);
                map.get(heap.get(i).val).remove(Integer.valueOf(new Integer(i)));
                map.get(heap.get(i).val).add(parent);

                Collections.swap(heap, parent, i);
                heapup(parent);
            }
        }
    }

    int higherPrio(int parent, int child) {
        if (child < heap.size() &&
                heap.get(child).priority < heap.get(parent).priority)
            return child;
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
                map.get(heap.get(child).val).add(i);
                map.get(heap.get(i).val).remove(Integer.valueOf(i));
                map.get(heap.get(i).val).add(child);

                heapdown(child);
            }
        }

    }


}