/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import dao.Client;
import dao.Contrat;
import dao.Facture;

import dao.Parc;
import dao.Reservation;
import dao.TcPays;
import dao.Voiture;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author TECHNOPC
 */
public class ImetierImpl implements Imetier{

     public static final SessionFactory factory = HibernateUtil.getSessionFactory();
    @Override
    public void ajouterClient(Client cl) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(cl);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        
    }

    @Override
    public void modifierClient(Client cl) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(cl);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void supprimerClient(Client cl) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(cl);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Client> listerClient() {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Client> clients=null;
        try {
            tx = session.beginTransaction();
            Query query=session.createQuery("From Client");
            clients=query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return clients;
    }
    

    @Override
    public List<TcPays> listerPays() {
 Session session = factory.openSession();
        Transaction tx = null;
        List<TcPays> pays=null;
        try {
            tx = session.beginTransaction();
            Query query=session.createQuery("From TcPays");
            pays=query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return pays;    }

    @Override
    public Integer ajouterVoiture(Voiture v) {
 Session session = factory.openSession();
        Transaction tx = null;
        Integer id=null;
        try {
            tx = session.beginTransaction();
            id=(Integer) session.save(v);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }  
        return id;
    }

    @Override
    public void modifierVoiture(Voiture v) {
 Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(v);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }    }

    @Override
    public void supprimerVoiture(Voiture v) {
 Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(v);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }    }

    @Override
    public List<Voiture> listerVoiture() {
 Session session = factory.openSession();
        Transaction tx = null;
        List<Voiture> voitures=null;
        try {
            tx = session.beginTransaction();
            Query query=session.createQuery("From Voiture");
            voitures=query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return voitures;   
    }

    @Override
    public void ajouterParc(Parc parc) {
Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(parc);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }    }

    @Override
    public List<Parc> listerParc() {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Parc> parcs=null;
        try {
            tx = session.beginTransaction();
            Query query=session.createQuery("From Parc");
            parcs=query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return parcs;  
    }

    @Override
    public void supprimerParc(Parc p) {
Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(p);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }    }

    @Override
    public void modifierParc(Parc p) {
Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(p);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }    
    }

    


    @Override
    public void ajouterReservation(Reservation r) {
Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(r);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }    
    }

    @Override
    public void modifierReservation(Reservation r) {
Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(r);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }    
    }

    @Override
    public List<Reservation> listerReservation() {
 Session session = factory.openSession();
        Transaction tx = null;
        List<Reservation> reservations=null;
        try {
            tx = session.beginTransaction();
            Query query=session.createQuery("From Reservation");
            reservations=query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return reservations;  
    }

    @Override
    public void supprimerReservation(Reservation r) {
Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(r);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }        }

    @Override
    public void ajouterContrat(Contrat c) {
  Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(c);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
            }

    @Override
    public void ajouterFacture(Facture f) {
  Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(f);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
            }

   

    @Override
    public Voiture voitureParId(Integer id) {
Session session = factory.openSession();
        Transaction tx = null;
        Voiture vt=null;
        try {
            tx = session.beginTransaction();
            vt=(Voiture)session.get(Voiture.class,id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return vt;         }

    @Override
    public List<Voiture> voitureParMotCle(String modele, String marque, String Categ, String carb) {
         Session session = factory.openSession();
        Transaction tx = null;
        List<Voiture> voitures = null;
        try {
            tx = session.beginTransaction();
            Query req = session.createQuery("from Voiture v where v.marqueVoiture like :x and"
                    + " v.modeleVoiture like :y and"
                    + " v.categorieVoiture like :z and"
                    + " v.carburantVoiture like :t ");
            req.setParameter("x", "%" + marque + "%");
             req.setParameter("y", "%" + modele + "%");
              req.setParameter("z", "%" + Categ + "%");
               req.setParameter("t", "%" + carb + "%");
            voitures = req.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return voitures;
    }

    @Override
    public Client clientParId(Integer Id) {
        Session session = factory.openSession();
        Transaction tx = null;
        Client client=null;
        try {
            tx = session.beginTransaction();
            client=(Client)session.get(Client.class, Id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return client;
    }    

    
}
