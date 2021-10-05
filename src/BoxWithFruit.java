import java.util.ArrayList;

public class BoxWithFruit<T extends Fruit>{
   private ArrayList <T> list;

    public BoxWithFruit(ArrayList<T> list) {

        this.list = list;
    }

       //метод вычисления веса коробки с фруктами
  public float getWeight () {
      float w = 0.0f;
      for (T fruit : list) {
          w += fruit.getWeight();
      }
      return w;
  }

        //метод сравнения веса коробок текущей и поданной на вход метода

        public boolean compare (BoxWithFruit <?> another) {
        return Math.abs(getWeight() - another.getWeight())<=0.000001;

    }
    //метод для добавления фруктов в коробку

    public void addFruit (T fruit) {
      list.add(fruit);
    }

    //метод пересыпания фруктов из коробки в коробку
    //в коробку с одним видом фруктов можно насыпать только теже фрукты

      public void pourFruits (BoxWithFruit<T> another){
        if (this == another) {
            return;
        }

      another.list.addAll(this.list);
      this.list.clear();

      }


    }




