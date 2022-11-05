package laptrinhandroid.fpoly.dnnhm3.DAO;


import static laptrinhandroid.fpoly.dnnhm3.DAO.Collection.*;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import laptrinhandroid.fpoly.dnnhm3.Entity.NhanVien;


public class Dao<T> {
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public Dao () {

    }

    public void addObject(Object obj, String collectionPath, addObject addObject) {
        try {
            db.collection(collectionPath)
                    .add(obj)
                    .addOnSuccessListener(documentReference -> {
                        Map<String, Object> objectMap = new HashMap<String, Object>();
                        objectMap.put(check(collectionPath), documentReference.getId());
                        documentReference.update(objectMap);
                        addObject.addOnSuccess(documentReference);
                    })
                    .addOnFailureListener(addObject::onFailure);
        } catch (Exception e) {
            Log.d("sssssssss", "addObject: "+e.getMessage());

        }
    }


    public void deleteObject(String collectionPath, String documentPath, resultObject resultObject) {
        try {
            db.collection(collectionPath).document(documentPath)
                    .delete()
                    .addOnSuccessListener(resultObject::OnSuccess)
                    .addOnFailureListener(resultObject::onFailure);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void updateObject(String collectionPath,
                             String documentPath,
                             Map<String, Object> newContact,
                             resultObject updateObject) {
        try {
            db.collection(collectionPath).document(documentPath).set(newContact)
                    .addOnSuccessListener(updateObject::OnSuccess)
                    .addOnFailureListener(updateObject::onFailure);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void getListObject(Class aClass,
                              String collectionPath,
                              getObject getObject) {
        try {
            db.collection(collectionPath).get()
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            List<Object> aClasses = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                aClasses.add(document.toObject(aClass));
                            }
                            getObject.OnSuccess(aClasses);
                        } else {
                            getObject.onFailure(Objects.requireNonNull(task.getException()));
                        }
                    });
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private String check(String collectionPath) {
        switch (collectionPath) {
            case "NhanVien":
                return "maNv";
            case "BangLuong":
                return "id";
            case "ChamCong":
                return "maCong";
            case "ChiTietHoaDon":
                return "id";
            case "HoaDonBan":
                return "maHDBan";
            case "HoaDonNhapKho":
                return "maHDNhap";
            case "KhachHang":
                return "maKhach";
            case "LoaiSanPham":
                return "maLoai";
            case "SanPham":
                return "maSP";
            default:
        }
        return "";
    }

    public interface getObject {
        void OnSuccess(List<Object> objects);

        void onFailure(@NonNull Exception e);
    }

    public interface addObject {
        void addOnSuccess(DocumentReference documentReference);

        void onFailure(@NonNull Exception e);
    }

    public interface resultObject {

        void OnSuccess(Void unused);

        void onFailure(@NonNull Exception e);
    }


}
