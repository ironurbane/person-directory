package org.jasig.services.persondir.criteria;


public abstract class CompareCriteria<V> implements Criteria {
    private final String attribute;
    private final V value;

    public CompareCriteria(String attribute, V value) {
        this.attribute = attribute;
        this.value = value;
    }
    
    public final String getAttribute() {
        return attribute;
    }

    public final V getValue() {
        return value;
    }

    @Override
    public Criteria getNegatedForm() {
        return new NotCriteria(this);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((attribute == null) ? 0 : attribute.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CompareCriteria<?> other = (CompareCriteria<?>) obj;
        if (attribute == null) {
            if (other.attribute != null)
                return false;
        } else if (!attribute.equals(other.attribute))
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

    @Override
    public String toString() {
        final ToStringCriteriaProcessor processor = new ToStringCriteriaProcessor();
        this.process(processor);
        return processor.toString();
    }
}