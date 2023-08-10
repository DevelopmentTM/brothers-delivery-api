package com.developmentteam.brothersdeliveryapi.entities.auth;

import com.developmentteam.brothersdeliveryapi.entities.auth.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reset_code", schema = "public")
public class ResetCode {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "resetCodeId")
   private Long resetCodeId;

   @Column(name =  "resetCode", nullable = false, length = 255)
   private Integer resetCode;

   @Column(name =  "resetCodeExpiryAt", nullable = false)
   private LocalDateTime resetCodeExpiryAt;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
   private User resetCodeUser;

}
