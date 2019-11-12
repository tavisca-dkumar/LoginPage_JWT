//package login.service;
//
//import login.entity.UserDao;
//import login.repository.AdminRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class LoginService {
//
//    @Autowired
//    AdminRepository repository;
//
//    public Boolean validation(UserDao admin){
//        if(repository.findById(admin.getEmployeeId()).isPresent())
//        {
//            if(admin.getPassword().equals(repository.findById(admin.getEmployeeId()).get().getPassword()))
//                return true;
//            else
//                return false;
//        }
//        else
//            return false;
//
//
//    }
//
//}
