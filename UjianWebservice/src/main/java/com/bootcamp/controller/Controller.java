package com.bootcamp.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JFrame;

import com.bootcamp.Ujian.model.Personnel;
import com.bootcamp.webservice.model.Anggota;
import com.bootcamp.webservice.model.Buku;
import com.bootcamp.webservice.model.Peminjaman;
import com.bootcamp.webservice.model.Petugas;
import com.bootcamp.webservice.model.Rak;



public class Controller {

	EntityManager em;


	private Controller() {

		em = Service.getInstance().getEntityManager().createEntityManager();

	}

	public static Controller getInstance() {

		return ControllerHolder.INSTANCE;

	}

	public static class ControllerHolder {
		private static final Controller INSTANCE = new Controller();
	}

	public boolean Login(String username, String password) {

		Petugas result = em.find(Petugas.class, username);

		if (result != null) {
			if (result.getPassword().equals(password)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	public void saveDataAnggota(Anggota anggota) {

		em.getTransaction().begin();
		em.merge(anggota);

		em.getTransaction().commit();

	

	}

	public List<Anggota> getAllAnggota() {

		// "select a from Anggota a where a.username ='"+txtUsername+"' and a.password =
		// '+
		TypedQuery<Anggota> query = em.createQuery("select a from Anggota a", Anggota.class);

		return query.getResultList();

	}

	public List<Petugas> getAllPetugas() {

		// "select a from Anggota a where a.username ='"+txtUsername+"' and a.password =
		// '+
		TypedQuery<Petugas> query = em.createQuery("select a from Petugas a", Petugas.class);

		return query.getResultList();

	}
	
	public List<Buku> getAllBuku() {

		// "select a from Anggota a where a.username ='"+txtUsername+"' and a.password =
		// '+
		TypedQuery<Buku> query = em.createQuery("select a from Buku a", Buku.class);

		return query.getResultList();

	}
	
	
	public List<Rak> getAllRak() {

		// "select a from Anggota a where a.username ='"+txtUsername+"' and a.password =
		// '+
		TypedQuery<Rak> query = em.createQuery("select a from Rak a", Rak.class);

		return query.getResultList();

	}
	
	public List<Peminjaman> getAllPeminjaman() {

		// "select a from Anggota a where a.username ='"+txtUsername+"' and a.password =
		// '+
		TypedQuery<Peminjaman> query = em.createQuery("select a from Peminjaman a", Peminjaman.class);

		return query.getResultList();

	}

	public void saveDataPetugas(Petugas petugas) {

		em.getTransaction().begin();
		em.merge(petugas);
		// em.persist(petugas);

		em.getTransaction().commit();

	}
	
	public void saveDataBuku(Buku buku) {

		em.getTransaction().begin();
		em.merge(buku);
		// em.persist(petugas);

		em.getTransaction().commit();

	}
	
	public void saveDataRak(Rak rak) {

		em.getTransaction().begin();
		em.merge(rak);
		// em.persist(petugas);

		em.getTransaction().commit();

	}
	
	
	public void deleteDataPetugas(Petugas petugas) {

		em.getTransaction().begin();
		em.remove(petugas);

		em.getTransaction().commit();

	}
	
	public void deleteDataBuku(Buku buku) {

		em.getTransaction().begin();
		em.remove(buku);

		em.getTransaction().commit();

	}
	
	public void deleteDataRak(Rak rak) {

		em.getTransaction().begin();
		em.remove(rak);

		em.getTransaction().commit();

	}

	public void deleteDataAnggota(Anggota anggota) {

		em.getTransaction().begin();
		em.remove(anggota);

		em.getTransaction().commit();

	}
	
	public void deleteDataPeminjaman(Peminjaman anggota) {

		em.getTransaction().begin();
		em.remove(anggota);

		em.getTransaction().commit();

	}

	

	public boolean checkPassword(String username, String password) {

		TypedQuery<Petugas> query = em.createQuery(
				"select a from Petugas a where a.kodePetugas = '" + username + "' and a.password ='" + password + "'",
				Petugas.class);

		int row = query.getResultList().size();

		if (row > 0) {
			return true;
		} else {
			return false;
		}

	}

	public Petugas checkPassword2(String username, String password) {

		TypedQuery<Petugas> query = em.createQuery(
				"select a from Petugas a where a.kodePetugas = '" + username + "' and a.password ='" + password + "'",
				Petugas.class);

		return query.getSingleResult();

	}

	public List<Anggota> searchName(String name) {

		TypedQuery<Anggota> query = em.createQuery("select a from Anggota a where a.nama like '%" + name + "%'",
				Anggota.class);

		return query.getResultList();

	}
	
	public List<Petugas> searchNamePetugas(String name) {

		TypedQuery<Petugas> query = em.createQuery("select a from Petugas a where a.nama like '%" + name + "%'",
				Petugas.class);

		return query.getResultList();

	}
	public List<Buku> searchNameBuku(String name) {

		TypedQuery<Buku> query = em.createQuery("select a from Buku a where a.judul like '%" + name + "%'",
				Buku.class);

		return query.getResultList();

	}
	
	
	public List<Rak> searchNameRak(String name) {

		TypedQuery<Rak> query = em.createQuery("select a from Rak a where a.namaRak like '%" + name + "%'",
				Rak.class);

		return query.getResultList();

	}
	
	public Rak searchKodeRak(String name) {

		TypedQuery<Rak> query = em.createQuery("select a from Rak a where a.kodeRak  ='" + name + "'",
				Rak.class);

		return query.getSingleResult();

	}
	
	public Anggota saveDataAnggotaX(Anggota anggota) {

		em.getTransaction().begin();
		em.merge(anggota);

		em.getTransaction().commit();

		return anggota;
	}
	
	public Petugas saveDataPetugasX(Petugas petugas) {

		em.getTransaction().begin();
		em.merge(petugas);
		// em.persist(petugas);

		em.getTransaction().commit();

		return petugas;
	}
	
	public Peminjaman saveDataPeminjaman(Peminjaman petugas) {

		em.getTransaction().begin();
		em.merge(petugas);
		// em.persist(petugas);

		em.getTransaction().commit();

		return petugas;
	}
	
	public void saveDataAnggotaService(Anggota anggota) {

		
		Anggota test = new Anggota();
		
		test.setKodeAnggota(anggota.getKodeAnggota());
		test.setNama(anggota.getNama());
		test.setJenisKelamin(anggota.getJenisKelamin());
		test.setAngkatan(anggota.getAngkatan());
		
		
		
		em.getTransaction().begin();
		em.merge(test);

		em.getTransaction().commit();

	

	}

	public List<Personnel> getAllPersonnel() {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveDataPersonnel(Personnel personnel) {
		// TODO Auto-generated method stub
		
	}

	public List<Personnel> searchid(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
