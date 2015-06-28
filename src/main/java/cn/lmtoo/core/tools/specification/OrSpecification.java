package cn.lmtoo.core.tools.specification;

public class OrSpecification<T> implements Specification<T> {
	private Specification<T> one;
	private Specification<T> other;

	public OrSpecification(Specification<T> one, Specification<T> other) {
		this.one = one;
		this.other = other;
	}

	@Override
	public boolean isSatisfiedBy(T target) {
		return one.isSatisfiedBy(target) || other.isSatisfiedBy(target);
	}
}
