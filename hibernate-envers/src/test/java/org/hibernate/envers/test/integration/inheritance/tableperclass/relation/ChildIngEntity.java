/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2008, Red Hat Middleware LLC or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Middleware LLC.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */

package org.hibernate.envers.test.integration.inheritance.tableperclass.relation;
import javax.persistence.Basic;
import javax.persistence.Entity;

import org.hibernate.envers.Audited;

/**
 * @author Adam Warski (adam at warski dot org)
 */
@Entity
@Audited
public class ChildIngEntity extends ParentIngEntity {
    @Basic
    private Long numVal;

    public ChildIngEntity() {
    }

    public ChildIngEntity(Integer id, String data, Long numVal) {
        super(id, data);
        this.numVal = numVal;
    }

    public Long getNumVal() {
        return numVal;
    }

    public void setNumVal(Long numVal) {
        this.numVal = numVal;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChildIngEntity)) return false;
        if (!super.equals(o)) return false;

        ChildIngEntity childEntity = (ChildIngEntity) o;

        if (numVal != null ? !numVal.equals(childEntity.numVal) : childEntity.numVal != null) return false;

        return true;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (numVal != null ? numVal.hashCode() : 0);
        return result;
    }

    public String toString() {
        return "ChildIngEntity(id = " + getId() + ", data = " + getData() + ", numVal = " + numVal + ")";
    }
}