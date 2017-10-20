package com.hp.up.core.Entity;

/**
 * IDEntity
 * @Author haopeng
 * @Date 2017/9/5 16:41
 */
public class IdEntity extends BaseEntity {

    private static final long serialVersionUID = 1632432797838286376L;

    private Long id;

    public IdEntity() {
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (this.createBy == null?0:this.createBy.hashCode());
        result = 31 * result + (this.createDate == null?0:this.createDate.hashCode());
        result = 31 * result + (this.id == null?0:this.id.hashCode());
        result = 31 * result + (this.modifyBy == null?0:this.modifyBy.hashCode());
        result = 31 * result + (this.modifyDate == null?0:this.modifyDate.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        } else if(!super.equals(obj)) {
            return false;
        } else if(this.getClass() != obj.getClass()) {
            return false;
        } else {
            IdEntity other = (IdEntity)obj;
            if(this.createBy == null) {
                if(other.createBy != null) {
                    return false;
                }
            } else if(!this.createBy.equals(other.createBy)) {
                return false;
            }

            if(this.createDate == null) {
                if(other.createDate != null) {
                    return false;
                }
            } else if(!this.createDate.equals(other.createDate)) {
                return false;
            }

            if(this.id == null) {
                if(other.id != null) {
                    return false;
                }
            } else if(!this.id.equals(other.id)) {
                return false;
            }

            if(this.modifyBy == null) {
                if(other.modifyBy != null) {
                    return false;
                }
            } else if(!this.modifyBy.equals(other.modifyBy)) {
                return false;
            }

            if(this.modifyDate == null) {
                if(other.modifyDate != null) {
                    return false;
                }
            } else if(!this.modifyDate.equals(other.modifyDate)) {
                return false;
            }

            return true;
        }
    }
}
