/** Treating individual and aggregate(list) objects uniformly
 * It is a structural pattern */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

class Scratch {
    public static void main(String[] args) {
        ValueContainer singleValue = new SingleValue(1);
        ValueContainer singleValue2 = new SingleValue(7);

        ManyValues manyValues = new ManyValues();
        manyValues.add(3);
        manyValues.add(5);

        ArrayList<ValueContainer> valueContainers = new ArrayList<>();
        valueContainers.add(singleValue);
        valueContainers.add(singleValue2);
        valueContainers.add(manyValues);

        MyList myList = new MyList(valueContainers);
        System.out.println(myList.sum());

    }
}

interface ValueContainer extends Iterable<Integer> {
    default int sum() {
        int sum = 0;
        for (int value:this){
            sum+=value;
        }
        return sum;
    }
}

class SingleValue implements ValueContainer
{
    public int value;

    // please leave this constructor as-is
    public SingleValue(int value)
    {
        this.value = value;
    }

    @Override
    public Iterator<Integer> iterator() {
        return Collections.singleton(this.value).iterator();
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        action.accept(this.value);
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return Collections.singleton(this.value).spliterator();
    }
}

class ManyValues extends ArrayList<Integer> implements ValueContainer
{
}


class MyList extends ArrayList<ValueContainer>
{
    // please leave this constructor as-is
    public MyList(Collection<? extends ValueContainer> c)
    {
        super(c);
    }

    public int sum()
    {
       int sum = 0;
        for (ValueContainer element:this) {
            sum+=element.sum();
        }
        return sum;
    }
}