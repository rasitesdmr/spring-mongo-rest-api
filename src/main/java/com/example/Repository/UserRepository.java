package com.example.Repository;

import com.example.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/*
Entity aracılığıyla veri tabanına bağlanıp , veritabanından getir , veritabanına kaydet gibi
kök işlemlerimizi yapacak tamamı repository mizin içinde bulunacak ( User ) -> ( UserRepository ).
 */


/*
Biz sürekli aynı kodu kopyala yapıştır gibi bir işlem yapıyoruz .
Bu class ı tekrak tekrar yazmamıza bir çözüm üretmişler .
Demişler biz bir tane interface yazalım bu interface mizin içerisine bunları
oluşturalım bunları herkes tekrardan yazmaya ihtiyaç duymasın.
Buna ekstra olarak eklenmesi gereken methodlar olursa kendimiz ekleyebiliriz .
*/
public interface UserRepository extends MongoRepository<User, String> {

}
