package sn.organisation.pav.entite;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
@Embeddable
public final class RoleEmployePK implements Serializable {

	private static final long serialVersionUID = 1L;

	public String toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }

	public String toJson(String[] fields) {
        return new JSONSerializer().include(fields).exclude("*.class").serialize(this);
    }

	public static RoleEmployePK fromJsonToRoleEmployePK(String json) {
        return new JSONDeserializer<RoleEmployePK>().use(null, RoleEmployePK.class).deserialize(json);
    }

	public static String toJsonArray(Collection<RoleEmployePK> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }

	public static String toJsonArray(Collection<RoleEmployePK> collection, String[] fields) {
        return new JSONSerializer().include(fields).exclude("*.class").serialize(collection);
    }

	public static Collection<RoleEmployePK> fromJsonArrayToRoleEmployePKs(String json) {
        return new JSONDeserializer<List<RoleEmployePK>>().use(null, ArrayList.class).use("values", RoleEmployePK.class).deserialize(json);
    }

	@Column(name = "CODE_ROLE", nullable = false, length = 20)
    private String codeRole;

	@Column(name = "CODE_EMPLOYE", nullable = false, length = 100)
    private String codeEmploye;

	@Column(name = "CODE_APPLICATION", nullable = false, length = 20)
    private String codeApplication;

	public RoleEmployePK(String codeRole, String codeEmploye, String codeApplication) {
        super();
        this.codeRole = codeRole;
        this.codeEmploye = codeEmploye;
        this.codeApplication = codeApplication;
    }

	private RoleEmployePK() {
        super();
    }

	public String getCodeRole() {
        return codeRole;
    }

	public String getCodeEmploye() {
        return codeEmploye;
    }

	public String getCodeApplication() {
        return codeApplication;
    }
}
