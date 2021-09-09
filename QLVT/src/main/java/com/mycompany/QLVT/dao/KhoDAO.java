/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.QLVT.dao;

import com.mycompany.QLVT.Entity.Kho;
import com.mycompany.QLVT.Entity.NhanVien;
import com.mycompany.QLVT.Mapper.KhoMapper;
import com.mycompany.QLVT.Mapper.NhanVienMapper;
import java.util.List;

/**
 *
 * @author zoroONE01
 */
public class KhoDAO extends AbstractDAO<Kho>{
    public List<Kho> findAll() {
        return queryProcedure("exec spShowKho", new KhoMapper());
    }

    public Kho findOne(String id) {
        List<Kho> listKho = queryProcedure("{call spSearchKho(?)}", new KhoMapper(), id);
        return listKho.isEmpty() ? null : listKho.get(0);
    }

    public void delete(String id) {
        update("{call spDeleteKho(?)}", id);
    }

    public void save(Kho kho) {
    insert("{call spInsertKho(?,?,?,?)}", kho.getMaKho(),kho.getTenKho(),kho.getDiaChi(),kho.getMaCN());

    }
    public void update(Kho kho) {
    update("{call spUpdateKho(?,?,?,?,?,?,?)}", kho.getMaKho(),kho.getTenKho(),kho.getDiaChi(),kho.getMaCN());

    }
}
