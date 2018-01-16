/**
 * This class is generated by jOOQ
 */
package services.generated.tables.records


import java.lang.Integer
import java.lang.String

import javax.annotation.Generated

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record3
import org.jooq.Row3
import org.jooq.impl.UpdatableRecordImpl

import services.generated.tables.FeatureToggle


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = Array(
		"http://www.jooq.org",
		"jOOQ version:3.7.2"
	),
	comments = "This class is generated by jOOQ"
)
class FeatureToggleRecord extends UpdatableRecordImpl[FeatureToggleRecord](FeatureToggle.FEATURE_TOGGLE) with Record3[Integer, String, String] {

	/**
	 * Setter for <code>public.feature_toggle.id</code>.
	 */
	def setId(value : Integer) : Unit = {
		setValue(0, value)
	}

	/**
	 * Getter for <code>public.feature_toggle.id</code>.
	 */
	def getId : Integer = {
		val r = getValue(0)
		if (r == null) null else r.asInstanceOf[Integer]
	}

	/**
	 * Setter for <code>public.feature_toggle.username</code>.
	 */
	def setUsername(value : String) : Unit = {
		setValue(1, value)
	}

	/**
	 * Getter for <code>public.feature_toggle.username</code>.
	 */
	def getUsername : String = {
		val r = getValue(1)
		if (r == null) null else r.asInstanceOf[String]
	}

	/**
	 * Setter for <code>public.feature_toggle.has_toggle</code>.
	 */
	def setHasToggle(value : String) : Unit = {
		setValue(2, value)
	}

	/**
	 * Getter for <code>public.feature_toggle.has_toggle</code>.
	 */
	def getHasToggle : String = {
		val r = getValue(2)
		if (r == null) null else r.asInstanceOf[String]
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------
	override def key() : Record1[Integer] = {
		return super.key.asInstanceOf[ Record1[Integer] ]
	}

	// -------------------------------------------------------------------------
	// Record3 type implementation
	// -------------------------------------------------------------------------

	override def fieldsRow : Row3[Integer, String, String] = {
		super.fieldsRow.asInstanceOf[ Row3[Integer, String, String] ]
	}

	override def valuesRow : Row3[Integer, String, String] = {
		super.valuesRow.asInstanceOf[ Row3[Integer, String, String] ]
	}
	override def field1 : Field[Integer] = FeatureToggle.FEATURE_TOGGLE.ID
	override def field2 : Field[String] = FeatureToggle.FEATURE_TOGGLE.USERNAME
	override def field3 : Field[String] = FeatureToggle.FEATURE_TOGGLE.HAS_TOGGLE
	override def value1 : Integer = getId
	override def value2 : String = getUsername
	override def value3 : String = getHasToggle

	override def value1(value : Integer) : FeatureToggleRecord = {
		setId(value)
		this
	}

	override def value2(value : String) : FeatureToggleRecord = {
		setUsername(value)
		this
	}

	override def value3(value : String) : FeatureToggleRecord = {
		setHasToggle(value)
		this
	}

	override def values(value1 : Integer, value2 : String, value3 : String) : FeatureToggleRecord = {
		this.value1(value1)
		this.value2(value2)
		this.value3(value3)
		this
	}

	/**
	 * Create a detached, initialised FeatureToggleRecord
	 */
	def this(id : Integer, username : String, hasToggle : String) = {
		this()

		setValue(0, id)
		setValue(1, username)
		setValue(2, hasToggle)
	}
}
