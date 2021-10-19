package data_classes_enums_simple_classes

class SimpleEmployeeWithOverriding(var id: Int, var Name: String, var Surname: String, val profession: Professions) {
  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as SimpleEmployeeWithOverriding

    if (id != other.id) return false
    if (Name != other.Name) return false
    if (Surname != other.Surname) return false
    if (profession != other.profession) return false

    return true
  }

  override fun hashCode(): Int {
    var result = id
    result = 31 * result + Name.hashCode()
    result = 31 * result + Surname.hashCode()
    result = 31 * result + profession.hashCode()
    return result
  }

  override fun toString(): String {
    return "SimpleEmployeeWithOverriding(id=$id, Name='$Name', Surname='$Surname', profession='$profession')"
  }
}