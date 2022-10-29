package com.tabdaul.tabanewsapp.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author MOSAED ALOTAIBI (MASAAD)
 * @created 10/29/2022 at 20:45
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPrivilegesId implements Serializable {
    private Long user;
    private Long privilege;

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

        var that = (UserPrivilegesId) obj;

        return (this.getPrivilege() == that.getPrivilege()) && (this.getUser() == that.getUser());
    }
}
