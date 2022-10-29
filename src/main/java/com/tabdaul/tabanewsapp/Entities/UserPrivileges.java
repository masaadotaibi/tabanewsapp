package com.tabdaul.tabanewsapp.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author MOSAED ALOTAIBI (MASAAD)
 * @created 10/29/2022 at 20:39
 *
 * User Privileges.
 * This will be a through table, and Users will know their privileges from this table, and
 * Privileges will know their users from this table
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER_PRIVILEGES")
@IdClass(UserPrivilegesId.class)
public class UserPrivileges {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "privilege_id")
    private Privilege privilege;

    @Override
    public int hashCode() {
        return 10;
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == this) {
            return true;
        }

        if(obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        var that = (UserPrivileges) obj;

        // below 2 lines check if this object privilege dependency is null then assign it as 0,
        // if privilege is not null (it has an object) it will assign its value to the variable
        // the same thing is done with this object parameter object
        long thisPrivilegeId = this.getPrivilege() == null ? 0: this.getPrivilege().getId();
        long thatPrivilegeId = that.getPrivilege() == null ? 0: that.getPrivilege().getId();

        long thisUserId = this.getUser() == null ? 0: this.getUser().getId();
        long thatUserId = that.getUser() == null ? 0: that.getUser().getId();

        return (thisPrivilegeId == thatPrivilegeId) && (thisUserId == thatUserId);
    }

}
