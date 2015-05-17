package com.zed.bagofood;

/**
 * Created by Arnaud on 30/04/2015.
 */

import com.zed.bagofood.enumeration.Category;
import com.zed.bagofood.model.Foodlist;
import com.zed.bagofood.model.Item;
import com.zed.bagofood.model.User;
import com.zed.bagofood.repository.FoodListRepository;
import com.zed.bagofood.repository.ItemRepository;
import com.zed.bagofood.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    FoodListRepository foodListRepository;

    /**
     * Class Logger
     */
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        // users
//        User maurice = new User("Maurice", "Maurice@gmail.com");
//        User arnaud = new User("Arnaud", "Arnaud@gmail.com");
//
//        // save a couple of user
//        userRepository.save(maurice);
//        userRepository.save(arnaud);

        // items
//        Item item1 = new Item("item1", Category.BREAKFAST, 15, 30);
//        Item item2 = new Item("item2", Category.LUNCH, 445, 32);
//        Item item3 = new Item("item3", Category.BREAKFAST, 323, 43214);
//        Item item4 = new Item("item4", Category.SNACK, 4324, 324599);
//
//        itemRepository.save(item1);
//        itemRepository.save(item2);
//        itemRepository.save(item3);
//        itemRepository.save(item4);

        // food list
//        Foodlist foodList1 = new Foodlist(arnaud, "Liste 1", "Descttisifodfisn,");
//        Foodlist foodList2 = new Foodlist(arnaud, "Liste 2", "qsdklqdkqsklmqdmlsm");
//        Foodlist foodList3 = new Foodlist(maurice, "Liste 1", "kfjdskjfd^s");
//
//        foodList1.getItemList().add(item1);
//        foodList1.getItemList().add(item2);
//        foodList1.getItemList().add(item3);
//        foodList1.getItemList().add(item4);
//
//        foodList3.getItemList().add(item1);
//        foodList3.getItemList().add(item2);
//
//        // save a couple of food list
//        foodListRepository.save(foodList1);
//        foodListRepository.save(foodList2);
//        foodListRepository.save(foodList3);
//
//        logger.info(foodListRepository.findAll().toString());
//        logger.info(foodListRepository.findByUser_Id(1).toString());
    }

}
