/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import entite.Partenaire;
import entite.User;
import service.UserService;
import service.partServ;

/**
 *
 * @author bazinfo
 */
public class Projet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        database d=database.getInstance();
        System.out.println(d);
         /*User u=new User("khlifi","zeineb",2,"4521","nbgffg","hhhh");
        UserService uService=new UserService();
        uService.insert(u);*/
        User u1=new User("mtar","ons",5,"4521lll","nbgffgll","hhhh");
        UserService uService1=new UserService();
        uService1.insert(u1);
        System.out.println(uService1.displayAll());
        /*
       User u2=new User(1);
       UserService uService2=new UserService();
       uService2.delete(u2);*/
       /* User u3=new User(2,"chhh","ons",5,"4521lll","nbgffgll","hhhh");
        UserService uService3=new UserService();
        uService1.update(u3);*/
       
         User u2=new User(3);
        UserService uservice2=new UserService();
        User u3=uservice2.getById(u2);
        System.out.println(u3);
        Partenaire p4=new Partenaire("f", "adr"," description", "image", 2);
        Partenaire p2=new Partenaire(2);
        partServ p1=new partServ();
        //p1.update(p4);
      //  System.out.println(p1.displayAll());
       Partenaire u8=new Partenaire(2);
        partServ partServ2=new partServ();
        Partenaire u9=partServ2.getById(u8);
        System.out.println(u9);
        
       // p1.insert(p4);
       Partenaire u5=new Partenaire(2);
       partServ partSer=new partServ();
       Partenaire u7=partSer.getById(u5);
       
        System.out.println(u7);
        
                
        
       
    }
    
}
