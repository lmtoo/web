package cn.lmtoo.core.tools.specification;

public class NotSpecification<T> implements Specification<T> {
	private Specification<T> wrapped;

	public NotSpecification(Specification<T> wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public boolean isSatisfiedBy(T target) {
		return !wrapped.isSatisfiedBy(target);
	}
}