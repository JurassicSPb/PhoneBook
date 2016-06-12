package Phonebook;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Created by Юрий on 11.06.2016.
 */
public class Main {
public static void main (String [] args)
{
System.out.println ("Телефонная книга.");
Scanner sc = new Scanner (System.in);
ArrayList<Contact> list = new ArrayList<>();

while (true) {
    System.out.println ("Menu: \n 1. Добавить контакт \n 2. Показать все контакты \n 3. Выход \n 4. Удалить контакт");
    int i = sc.nextInt();
    if (i==1) {
        Contact book = new Contact();
        System.out.println("Введите имя: ");
        book.name = sc.next();
        System.out.println("Введите телефон: ");
        book.phone = sc.next();
        System.out.println("Введите email: ");
        book.email = sc.next();
        list.add(book);
    }
    else if (i==2)
    {
        if (list.size()==0)
        {
            System.out.println ("Телефонная книга пустая.");
            continue;
        }
        for (int k=0; k<list.size()-1; k++)
        {
            for (int j=0; j<list.size()-1-k; j++)
            {
                char left = list.get(j).name.toCharArray()[0];
                char right = list.get(j + 1).name.toCharArray()[0];
                if (left > right)
                {
                    Contact temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set((j + 1), temp);
                }
            }
        }
        for (int j=0; j<list.size(); j++)
        {
            System.out.println(list.get(j).name + " " + list.get(j).phone + " " + list.get(j).email);
        }
    }
    else if (i==3)
    {
        System.out.println ("Выход из программы");
        break;
    }
    else if (i==4)
    {
        if (list.size()==0)
        {
            System.out.println ("Телефонная книга пустая.");
            continue;
        }
       for (int j=0; j<list.size(); j++)
        {
            System.out.println(list.get(j).name);
        }
        System.out.println ("Введите имя из списка для удаления: ");
        String str = sc.next();
        for (int j=0; j<list.size(); j++)
        {
            if (str.equals(list.get(j).name))
            {
                list.remove(j);
                break;
            }
        }
    }
    else
    {
        System.out.println ("Неверно введенная команда: ");
    }
}

    }
}
